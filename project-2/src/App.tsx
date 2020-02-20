import React from "react";
import "./App.css";
import MainPage from "./components/main-page-component/MainPage";
import HomePageComponent from "./components/home-page-component/HomePageContainer";
import ProfilePageComponent from "./components/profile-page-component/ProfilePageContainer";
import Register from "./components/registration-component/RegistrationComponent";
import LoginComponent from "./components/login-component/LoginContainer";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import { store } from "./Store";
import { Provider } from "react-redux";

function App() {
  return (
    <div>
      <Provider store={store} >
      <BrowserRouter>
        <div className="App">
          <Route path="/" exact component={MainPage} />
          <Switch>
            <Route path="/main" component={MainPage} />
            <Route path="/Login" component={LoginComponent} />
            <Route path="/home" component={HomePageComponent} />
            <Route path="/profile" component={ProfilePageComponent} />
            <Route path="/register" component={Register} />
          </Switch>
        </div>
      </BrowserRouter>
      </Provider>
    </div>
  );
}

export default App;
