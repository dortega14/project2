import axios from "axios";

export const axiosConfg = axios.create({
    baseURL: 'http://localhost:8080/project2/'
});

export default axiosConfg;