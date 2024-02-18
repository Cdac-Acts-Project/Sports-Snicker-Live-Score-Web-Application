import NavBarForSports from "../../helper/NavBarForSports";
import SportsTab from "../Cricket/SportsTab";
import FootballCard from "./FootballCard";


const Football = () => {

  let first_name = localStorage.getItem("first_name");

  let last_name = localStorage.getItem("last_name");

  let name = first_name+ " " +last_name

  
  return <>
    <NavBarForSports path={name} pathName="sports-snicker" path1="logout" pathName1="login"/>
    <br />

    <SportsTab path1="Cricket" pathName1="sports-snicker" path2="football" pathName2="sports-snicker/football" path3="Hockey" pathName3="sports-snicker/hockey"/>

    <FootballCard/>
  </>

};

export default Football;

// const options = {
//   method: 'GET',
//   url: 'https://livescore6.p.rapidapi.com/matches/v2/list-live',
//   params: {
//     Category: 'soccer',
//     Timezone: '-7'
//   },
//   headers: {
//     'X-RapidAPI-Key': '17a449dbb8msh0ddd34241c5b186p1fca90jsnb7547bc483bd',
//     'X-RapidAPI-Host': 'livescore6.p.rapidapi.com'
//   }
// };

// try {
// 	const response = await axios.request(options);
// 	console.log(response.data);
// } catch (error) {
// 	console.error(error);
// }
