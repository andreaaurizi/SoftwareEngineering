
package com.mycompany.luglio2020;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MovieService", targetNamespace = "http://luglio2020.mycompany.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MovieService {


    /**
     * 
     * @return
     *     returns com.mycompany.luglio2020.MovieMap
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMovies", targetNamespace = "http://luglio2020.mycompany.com/", className = "com.mycompany.luglio2020.GetMovies")
    @ResponseWrapper(localName = "getMoviesResponse", targetNamespace = "http://luglio2020.mycompany.com/", className = "com.mycompany.luglio2020.GetMoviesResponse")
    public MovieMap getMovies();

    /**
     * 
     * @param arg0
     * @return
     *     returns com.mycompany.luglio2020.MovieImpl
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMovieByTitle", targetNamespace = "http://luglio2020.mycompany.com/", className = "com.mycompany.luglio2020.GetMovieByTitle")
    @ResponseWrapper(localName = "getMovieByTitleResponse", targetNamespace = "http://luglio2020.mycompany.com/", className = "com.mycompany.luglio2020.GetMovieByTitleResponse")
    public MovieImpl getMovieByTitle(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
