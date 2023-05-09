<template>
    <div class="home-content">
        <div class="activity-container" v-for="activity in Activities" :key="activity.id">
            <div class="activity-info">
                <h1>{{ activity.activity }}</h1>
                <h2>Type: {{ activity.type }}</h2>
                <h3>Participants: {{ activity.participants }}</h3>
                <p>Id: {{ activity.key }}</p>
                <!-- <p>Cost: ${{ activity.price }}</p> -->
                <button class="rm-button" v-on:click="removeActivity(activity.key)">Remove Activity</button>
                <button class="archive-button" v-on:click=" archiveActivity(activity)" >Archive Activity</button>
            </div>
        </div>
    </div>
</template>

<script>
import BackendService from '@/service/BackendService';

    export default {
        name: 'home-content',
        data(){
            return{
                Activities: []
            }
        },
        created(){
            BackendService.getActivitiesFromDb().then((response) => {
                this.Activities = response.data;
            })
        },
        methods: {
            removeActivity(key){
                BackendService.removeActivity(key).then((response)=>{
                    if(response.status === 200){
                        alert("Activity removed");
                    } else{
                        alert("Activity was not removed");
                    }
                })
            },
            archiveActivity(activity){
                BackendService.addActivityToArchive(activity).then((response) =>{
                    if(response.status ===201){
                        alert("Activity has been archived!");
                    } else {
                        alert("Activity was not archived.")
                    }
                })
            }
        }
    }
</script>

<style scoped>

.home-content{
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
}

.activity-container{
    border: 2px solid rgb(165, 143, 243);
    border-radius: 10px;
    /* margin: 30px 50px; */
    margin: 2% 2%;
    padding: 15px;
    background-color: rgb(179, 135, 220, 0.6);
}

.activity-info h1{
    color: rgb(46, 36, 235);
}

.activity-info h2{
    color: rgb(38, 245, 44);
}

.activity-info h3{
    color: rgba(200, 0, 255, 0.977);
}

.rm-button{
    color: rgb(73, 12, 73);
    background-color: rgb(246, 234, 235);
    border-radius: 5px;
    margin-right: 5px;
    cursor: pointer;
}

.archive-button{
    color: rgb(73, 12, 73);
    background-color: rgb(206, 245, 242);
    border-radius: 5px;
    cursor: pointer;
}


</style>  