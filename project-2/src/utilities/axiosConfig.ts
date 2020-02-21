import axios from "axios";

const iqIP = "10.41.29.161";
const iqIP2 = "10.41.42.80";
const usfIP = "10.226.80.204";
const local = "localhost";
const ec2IP = "";
const desky = "192.168.137.192"

export const axiosConfg = axios.create({
    baseURL: 'http://' + iqIP + ':8080/project2'
});
 
export default axiosConfg;