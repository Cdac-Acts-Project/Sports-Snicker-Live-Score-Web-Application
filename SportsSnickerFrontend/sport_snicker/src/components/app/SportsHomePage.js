import NavBarForSports from "../helper/NavBarForSports";
import CricketMatchCard from "./Cricket/CricketMatchCard";
import SportsTab from "./Cricket/SportsTab";

 

const SportsHomePage = () => {

  
  let first_name = localStorage.getItem("first_name");

  let last_name = localStorage.getItem("last_name");

  let name = first_name+ " " +last_name

  
  return <>
    <NavBarForSports path={name} pathName="sports-snicker" path1="logout" pathName1="login"/>
    <br />

    <SportsTab path1="Cricket" pathName1="sports-snicker" path2="football" pathName2="sports-snicker/football" path3="Hockey" pathName3="sports-snicker/hockey"/>
 
    <CricketMatchCard/>
  </>
}

export default SportsHomePage;


// axios.get(api, { headers: {"Authorization" : `Bearer ${token}`} })
//         .then(res => {
//             console.log(res.data);
//         this.setState({
//             items: res.data,  /*set response data in items array*/
//             isLoaded : true,
//             redirectToReferrer: false
//         })