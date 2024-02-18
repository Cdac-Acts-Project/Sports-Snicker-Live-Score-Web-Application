import NavBarForSports from "../../helper/NavBarForSports";
import SportsTab from "../Cricket/SportsTab";
import UnderConstruction from "../asset/UnderConstruction";


const Hockey = () => {

   // let jwtToken = localStorage.getItem("jwtToken");

    let user = localStorage.getItem("user");
  
    let name = user.first_name + " " + user.last_name;

  return <>
    <NavBarForSports path={name} pathName="sports-snicker" path1="logout" pathName1="login"/>
    <br />

    <SportsTab path1="Cricket" pathName1="sports-snicker" path2="football" pathName2="sports-snicker/football" path3="Hockey" pathName3="sports-snicker/hockey"/>

    <UnderConstruction/>
  </>
}

export default Hockey;
