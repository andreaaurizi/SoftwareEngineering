
package com.mycompany.luglio2020;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.luglio2020 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetMovieByTitle_QNAME = new QName("http://luglio2020.mycompany.com/", "getMovieByTitle");
    private final static QName _GetMovieByTitleResponse_QNAME = new QName("http://luglio2020.mycompany.com/", "getMovieByTitleResponse");
    private final static QName _GetMovies_QNAME = new QName("http://luglio2020.mycompany.com/", "getMovies");
    private final static QName _GetMoviesResponse_QNAME = new QName("http://luglio2020.mycompany.com/", "getMoviesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.luglio2020
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMovieByTitleResponse }
     * 
     */
    public GetMovieByTitleResponse createGetMovieByTitleResponse() {
        return new GetMovieByTitleResponse();
    }

    /**
     * Create an instance of {@link GetMovies }
     * 
     */
    public GetMovies createGetMovies() {
        return new GetMovies();
    }

    /**
     * Create an instance of {@link GetMoviesResponse }
     * 
     */
    public GetMoviesResponse createGetMoviesResponse() {
        return new GetMoviesResponse();
    }

    /**
     * Create an instance of {@link GetMovieByTitle }
     * 
     */
    public GetMovieByTitle createGetMovieByTitle() {
        return new GetMovieByTitle();
    }

    /**
     * Create an instance of {@link MovieImpl }
     * 
     */
    public MovieImpl createMovieImpl() {
        return new MovieImpl();
    }

    /**
     * Create an instance of {@link MovieEntry }
     * 
     */
    public MovieEntry createMovieEntry() {
        return new MovieEntry();
    }

    /**
     * Create an instance of {@link MovieMap }
     * 
     */
    public MovieMap createMovieMap() {
        return new MovieMap();
    }

    /**
     * Create an instance of {@link DirectorImpl }
     * 
     */
    public DirectorImpl createDirectorImpl() {
        return new DirectorImpl();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieByTitle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://luglio2020.mycompany.com/", name = "getMovieByTitle")
    public JAXBElement<GetMovieByTitle> createGetMovieByTitle(GetMovieByTitle value) {
        return new JAXBElement<GetMovieByTitle>(_GetMovieByTitle_QNAME, GetMovieByTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieByTitleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://luglio2020.mycompany.com/", name = "getMovieByTitleResponse")
    public JAXBElement<GetMovieByTitleResponse> createGetMovieByTitleResponse(GetMovieByTitleResponse value) {
        return new JAXBElement<GetMovieByTitleResponse>(_GetMovieByTitleResponse_QNAME, GetMovieByTitleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://luglio2020.mycompany.com/", name = "getMovies")
    public JAXBElement<GetMovies> createGetMovies(GetMovies value) {
        return new JAXBElement<GetMovies>(_GetMovies_QNAME, GetMovies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMoviesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://luglio2020.mycompany.com/", name = "getMoviesResponse")
    public JAXBElement<GetMoviesResponse> createGetMoviesResponse(GetMoviesResponse value) {
        return new JAXBElement<GetMoviesResponse>(_GetMoviesResponse_QNAME, GetMoviesResponse.class, null, value);
    }

}
