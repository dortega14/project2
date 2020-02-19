import axios from "axios";

const iqIP = "10.41.41.195";
const usfIP = "10.226.80.40";
const local = "localhost";
const ec2IP = "";
const desky = "192.168.137.192";
const usfGIP = "10.226.49.149";

export const axiosConfg = axios.create({
    baseURL: 'http://' + usfGIP + ':8080/project2'
});
 
export default axiosConfg;