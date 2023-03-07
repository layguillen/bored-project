// talking to the backend app, axios makes it easy to send Http methods
import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:9000'
});

export default{
    viewActivityFromAPI(){
        return http.get("/activity");
    },
    // addMovieToDatabase(movie){
    //     return http.post("/add-movie", movie);
    // },
    // getQuotesByMovie(id){
    //     return http.get(`/quotesByMovie/${id}`);
    // },
    // getAllQuotes(){
    //     return http.get("/quote")
    // },
    // getAllCharacters(){
    //     return http.get("/character")
    // }
}