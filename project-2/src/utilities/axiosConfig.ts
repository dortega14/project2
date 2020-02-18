import axios from "axios";

const iqIP = "10.41.41.195";
const usfIP = "10.226.80.40";
const local = "localhost";
const ec2IP = "";

export const axiosConfg = axios.create({
    baseURL: 'http://' + usfIP + ':8080/project2'
});
 
export default axiosConfg;