<template>
  <div id="app">
    <div class="header">
      <h1>UN-BORED</h1>
      <nav>
        <img src="https://www.pngitem.com/pimgs/m/634-6342297_menu-bar-icon-white-clipart-png-download-3.png" alt="menu-img">
        <div id="dropdown" class="dropdown">
          <router-link to="/">Home </router-link>  
          <router-link to="/about">About </router-link> 
          <router-link to="/bored">Bored?</router-link>
          <router-link to="/archive">Archive</router-link>
        </div>
      </nav>
    </div>
    <router-view/>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  
}

.header{
  display: flex;
  justify-content: space-between;
  align-items: center;
  color: rgb(246, 242, 242);
  background-color: #9385cf;
  margin-right: 20px;
  margin-left: 20px;
  padding: 5px 20px;
  border-radius: 5px;
}

nav {
  padding: 10px;
  display: inline-block;
  position: relative;
}

nav img{
  height: 3.6rem;
  border-radius: 10px;
  cursor: pointer;  
}

nav a {
  font-weight: bold;
  color: #bad2ea;
  text-decoration: none;
  
}

nav a.router-link-exact-active {
  color: #61d19f;
  text-decoration: underline;
}

.dropdown {
  display: none;
  position: absolute;
  /* width: 105%;
  overflow: auto; */
  background-color: rgb(82, 77, 234);
  border-radius: 10px;
  padding: 10px 5px;
  
}

nav:hover .dropdown{
  display: block;
  
}


</style>
