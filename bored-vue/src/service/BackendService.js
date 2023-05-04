// talking to the backend app, axios makes it easy to send Http methods
import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:9000'
});

export default{
    viewActivityFromAPI(){
        return http.get("/activity");
    },
    viewArchieveFromAPI(){
        return http.get("/archive");
    },
    addActivityToDb(activity){
        return http.post("/add-activity", activity);
    },
    getActivitiesFromDb(){
        return http.get("/all-activities");
    },
    removeActivity(key){
        return http.delete(`/delete/${key}`);
    },
    getActivityByType(type){
        return http.get(`/activity/${type}`);
    }

    // getQuotesByMovie(id){
    //     return http.get(`/quotesByMovie/${id}`);
    // },
    // getAllQuotes(){
    //     return http.get("/quote")
    // },
   
}