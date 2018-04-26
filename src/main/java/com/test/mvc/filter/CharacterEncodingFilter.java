package com.test.mvc.filter;

import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/9/29.
 */
public class CharacterEncodingFilter extends OncePerRequestFilter {
    private String encoding;

    private boolean forceEncoding = false;


    /**
     * Create a default {@code CharacterEncodingFilter},
     * with the encoding to be set via {@link #setEncoding}.
     * @see #setEncoding
     */
    public CharacterEncodingFilter() {
    }

    /**
     * Create a {@code CharacterEncodingFilter} for the given encoding.
     * @param encoding the encoding to apply
     * @since 4.2.3
     * @see #setEncoding
     */
    public CharacterEncodingFilter(String encoding) {
        this(encoding, false);
    }

    /**
     * Create a {@code CharacterEncodingFilter} for the given encoding.
     * @param encoding the encoding to apply
     * @param forceEncoding whether the specified encoding is supposed to
     * override existing request and response encodings
     * @since 4.2.3
     * @see #setEncoding
     * @see #setForceEncoding
     */
    public CharacterEncodingFilter(String encoding, boolean forceEncoding) {
        Assert.hasLength(encoding, "Encoding must not be empty");
        this.encoding = encoding;
        this.forceEncoding = forceEncoding;
    }


    /**
     * Set the encoding to use for requests. This encoding will be passed into a
     * {@link HttpServletRequest#setCharacterEncoding} call.
     * <p>Whether this encoding will override existing request encodings
     * (and whether it will be applied as default response encoding as well)
     * depends on the {@link #setForceEncoding "forceEncoding"} flag.
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * Set whether the configured {@link #setEncoding encoding} of this filter
     * is supposed to override existing request and response encodings.
     * <p>Default is "false", i.e. do not modify the encoding if
     * {@link HttpServletRequest#getCharacterEncoding()}
     * returns a non-null value. Switch this to "true" to enforce the specified
     * encoding in any case, applying it as default response encoding as well.
     */
    public void setForceEncoding(boolean forceEncoding) {
        this.forceEncoding = forceEncoding;
    }


    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("filter work....======================");
        if (this.encoding != null && (this.forceEncoding || request.getCharacterEncoding() == null)) {
            request.setCharacterEncoding(this.encoding);
            if (this.forceEncoding) {
                response.setCharacterEncoding(this.encoding);
            }
        }
        filterChain.doFilter(request, response);
    }

}
