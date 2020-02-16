import React from 'react';
import './App.css';
import MainPage from './components/main-page-component/MainPage.tsx'
import HomeP from './components/home-page-component/HomePageComponent.tsx'
import ProfileP from './components/profile-page-component/ProfilePageComponent.tsx'
import Register from './components/registration-component/RegistrationComponent.tsx'
import LoginComponent from './components/login-component/LoginContainer.tsx'
import {BrowserRouter, Switch, Route } from 'react-router-dom';
import {Links} from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <div className="App"> 
      <Route path="/" exact component={MainPage} />
      <Switch>
       <MainPage path="/main" component={MainPage} />
       <LoginComponent path="/Login" component={LoginComponent} />
        <HomeP path="/homeP" component={HomeP} />
        <ProfileP path="/profile" component={ProfileP} />
        <Register path="/register" component={Register} />
        </Switch> 
      </div>
    </BrowserRouter>
  );
}

export default App;
