// vbase-css tab gets the folloring template
<template>
    <div>
        <fieldset>
            <select name="activty-type" id="activity-type" class="type-filter" v-model="type">
                <option value="">Select Type</option>
                <option value="busywork">Busywork</option>
                <option value="charity">Charity</option>
                <option value="cooking">Cooking</option>
                <option value="diy">DIY</option>
                <option value="education">Education</option>
                <option value="music">Music</option>
                <option value="recreational">Recreational</option>
                <option value="social">Social</option>
            </select>
        </fieldset>
        <button v-on:click="getActivityByType(type)" class="get-activity">Get Activity</button>
        <div class="activity-by-type">
            <h2>{{ ActivityByType.activity }}</h2>
            <h2>Type: {{ ActivityByType.type }}</h2>
            <h2>$ {{ ActivityByType.price }}</h2>
            <h3>Number of participants: {{ ActivityByType.participants }}</h3>
            <button class="add-botton" v-on:click="addActivity(Activity)">Add to Favorites</button>
        </div>
        <h1>Random Activity Idea:</h1>
        <div class="activity-box">
            <h2>{{ Activity.activity }}</h2>
            <h2>Type: {{ Activity.type }}</h2>
            <h2>$ {{ Activity.price }}</h2>
            <h3>Number of participants: {{ Activity.participants }}</h3>
            <button class="add-botton" v-on:click="addActivity(Activity)">Add to Favorites</button>
        </div>
    </div>  
</template>

<script>
import BackendService from '@/service/BackendService';

    export default {
        name: 'activity-box',
        data(){
            return{
                Activity: Object,
                ActivityByType: Object,
                type: "",
            }
        },
        created(){
            BackendService.viewActivityFromAPI().then((response) =>{
                this.Activity = response.data;
            })
        }, 
        methods: {
            addActivity(activity){
                BackendService.addActivityToDb(activity).then((response)=>{
                    if(response.status === 201){
                        alert("Activity added!");
                    }
                })
            },
            getActivityByType(type){
                BackendService.getActivityByType(type).then((response =>{
                this.ActivityByType=response.data;
            }))
            },
        }
    }
</script>

<style scoped>

.activity-by-type{
    border: 2px solid rgb(165, 143, 243);
    border-radius: 10px;
    margin: 30px 50px;
    padding: 10px;
    background-color: rgb(179, 135, 220, 0.6);
}


.activity-box{
    border: 2px solid rgb(165, 143, 243);
    border-radius: 10px;
    margin: 30px 50px;
    padding: 10px;
    background-color: rgb(179, 135, 220, 0.6);
}

.add-button :hover{
    cursor: pointer;
}

.get-activity{
    border-radius: 5px;
}

</style>