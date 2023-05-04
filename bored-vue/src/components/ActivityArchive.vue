<template>
    <div>
        <div class="archive-container" v-for="activity in ActivityArchive" :key="activity.id">
            <div class="archived-activity-info">
                <h2>{{ activity.activity }}</h2>
                <h2>Type: {{ activity.type }}</h2>
            </div>          
        </div>
    </div>
</template>

<script>
import BackendService from '@/service/BackendService';

export default {
    name: 'activity-archive',
    data(){
        return{
            // make this an array of Objects
            ActivityArchive: []
        }
    },
    created(){
        BackendService.viewArchieveFromDb().then((response) =>{
            this.ActivityArchive = response.data;
        })
    },
    methods:{

    }
}

</script>

<style>

.archived-activity-info{
    border: 2px solid rgb(165, 143, 243);
    border-radius: 10px;
    background-color: rgb(138, 214, 214);
    margin: 30px 50px;
    
}


</style>