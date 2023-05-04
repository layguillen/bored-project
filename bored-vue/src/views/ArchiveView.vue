<template>
    <div>
        <h1>Your Completed Activities: </h1>
        <ActivityArchive />
    </div>
</template>

<script>
import ActivityArchive from '@/components/ActivityArchive.vue';


export default{
    name: "archive-view",
    components: { ActivityArchive }
}
</script>

<style>

</style>