<template>
    <div>
    <!-- TODO: create loop for activities here -->
        <div class="activity-container"></div>
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
        }
    }
</script>

<style scoped>

</style>  