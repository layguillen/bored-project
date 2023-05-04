// talking to the backend app, axios makes it easy to send Http methods
import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:9000'
});

export default{
    viewActivityFromAPI(){
        return http.get("/activity");
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
    },
    viewArchieveFromDb(){
        return http.get("/archived-activities");
    },
    addActivityToArchive(activity){
        return http.post("/add-archive", activity);
    }

    // getQuotesByMovie(id){
    //     return http.get(`/quotesByMovie/${id}`);
    // },
    // getAllQuotes(){
    //     return http.get("/quote")
    // },
   
}