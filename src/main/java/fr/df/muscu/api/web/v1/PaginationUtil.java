package fr.df.muscu.api.web.v1;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Utility class for handling pagination.
 *
 * <p>
 * Pagination uses the same principles as the
 * <a href="https://developer.github.com/v3/#pagination">Github API</api>, and
 * follow <a href="http://tools.ietf.org/html/rfc5988">RFC 5988 (Link
 * header)</a>.
 * </p>
 */
public class


PaginationUtil {
    public static final int ONE = 1;

    public static final int DEFAULT_OFFSET = ONE;

    public static final int MIN_OFFSET = ONE;

    public static final int DEFAULT_LIMIT = 20;

    public static final int MAX_LIMIT = 100;

    public static final String PER_PAGE = "";

    public static Pageable generatePageRequest(Integer offset, Integer limit) {
        if (offset == null || offset < MIN_OFFSET) {
            offset = DEFAULT_OFFSET;
        }
        if (limit == null || limit > MAX_LIMIT) {
            limit = DEFAULT_LIMIT;
        }
        return new PageRequest(offset - ONE, limit);
    }

    public static HttpHeaders generatePaginationHttpHeaders(Page page,
            String baseUrl, Integer offset, Integer limit)
                    throws URISyntaxException {

        if (offset == null || offset < MIN_OFFSET) {
            offset = DEFAULT_OFFSET;
        }
        if (limit == null || limit > MAX_LIMIT) {
            limit = DEFAULT_LIMIT;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", "" + page.getTotalElements());
        String link = "";

        if (offset < page.getTotalPages()) {
            link = createLink((offset + ONE), limit, baseUrl,
                    ">; rel=\"next\",");

        }
        if (offset > 1) {
            link += createLink((offset - ONE), limit, baseUrl,
                    ">; rel=\"prev\",");
        }
        link += createLink(page.getTotalPages(), limit, baseUrl,
                ">; rel=\"last\",")

        + createLink(ONE, limit, baseUrl, ">; rel=\"first\"");

        headers.add(HttpHeaders.LINK, link);
        return headers;
    }

    public static String createLink(int perPage, int limit, String baseUrl,
            String finish) throws URISyntaxException {
        return "<"
                + (new URI(baseUrl + "?page=" + perPage + "&per_page=" + limit))
                        .toString()
                + finish;
    }
}
