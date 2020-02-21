import axios from "axios";

const iqIP = "10.41.29.161";
const iqIP2 = "10.41.42.80";
const usfIP = "10.226.80.204";
const local = "localhost";
const ec2IP = "18.220.87.66";
const desky = "192.168.137.192"

export const axiosConfg = axios.create({
    baseURL: 'http://' + ec2IP + ':8081/project2-0.0.1-SNAPSHOT'
});
 
export default axiosConfg;