<template>
    <div>
        
    </div>
</template>

<script>
import BackendService from '@/service/BackendService';

export default {
    name: 'activity-archive',
    data(){
        return{
            // make this an array of Objects
            Activity: Object,
        }
    },
    created(){
        BackendService.viewArchiveFromAPI().then((response) =>{
            this.Activity = response.data;
        })
    },
    methods:{

    }
}

</script>

<style>
</style>