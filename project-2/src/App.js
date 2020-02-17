import React from "react";
import "./App.css";
import MainPage from "./components/main-page-component/MainPage.tsx";
import HomeP from "./components/home-page-component/HomePageComponent.tsx";
import ProfileP from "./components/profile-page-component/ProfilePageComponent.tsx";
import Register from "./components/registration-component/RegistrationComponent.tsx";
import LoginComponent from "./components/login-component/LoginContainer.tsx";
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
            <Route path="/homeP" component={HomeP} />
            <Route path="/profile" component={ProfileP} />
            <Route path="/register" component={Register} />
          </Switch>
        </div>
      </BrowserRouter>
      </Provider>
    </div>
  );
}

export default App;
