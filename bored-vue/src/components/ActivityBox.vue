// vbase-css tab gets the folloring template
<template>
    <div class="activity-box">
        <h1>{{ Activity.activity }}</h1>
        <h2>$ {{ Activity.price }}</h2>
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
        }
    }
</script>

<style scoped>

.activity-box{
    border: 1px solid pink;
}

</style>