// vbase-css tab gets the folloring template
<template>
    <div class="activity-box">
        <h1>{{ Activity.activity }}</h1>
        <h2>Type: {{ Activity.type }}</h2>
        <h2>$ {{ Activity.price }}</h2>
        <h3>Number of participants: {{ Activity.participants }}</h3>
        <button class="add-botton">Add to Favorites</button>
    </div>
</template>

<script>
import BackendService from '@/service/BackendService';

    export default {
        name: 'activity-box',
        data(){
            return{
                Activity: Object
            }
        },
        created(){
            BackendService.viewActivityFromAPI().then((response) =>{
                this.Activity = response.data;
            })
        }, 
        methods(){
            // TODO: add method to add activity to favorites (post to DB)
        }
    }
</script>

<style scoped>

.activity-box{
    border: 1px solid pink;
    margin: 20px;
    color: rgb(127, 25, 25);
}

.add-button :hover{
    cursor: pointer;
}

</style>