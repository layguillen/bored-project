<template>
    <div class="activity-container">
    <!-- TODO: check if activity.id is correct for key -->
        <div v-for="activity in Activities" :key="activity.id">
            <div class="activity-info">
                <h1>{{ activity.activity }}</h1>
                <h2>{{ activity.type }}</h2>
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
        }
    }
</script>

<style scoped>

</style>  