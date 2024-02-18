import axios from "axios";
import { useState, useEffect } from "react";
import options from "./FootballApi";
import { CircularProgress } from "@mui/material";
import Box from "@mui/material/Box";

const FootballCard = () => {
  const [matchInfo, setmatchInfo] = useState([]);

  const handleApi = async () => {
    try {
      const response = await axios.request(options);
      const res = JSON.stringify(response.data);
      const res1 = JSON.parse(res);
      setmatchInfo(res1.Stages);
      console.log(res1.Stages);
    } catch (error) {
      console.error(error);
    }
  };

  // useEffect(() => {
  //   handleApi();
  //   console.log(matchInfo);
  // },[]);


  if (matchInfo.length !== 0) {
    return (
      <div className="flex  flex-wrap">
        {matchInfo.map((data) => {
          return (
            <section className="lg:w-1/3" key={data.Sid}>
              <a
                title=""
                href=""
                target="blank"
                className="block mb-4 p-4 border border-white rounded-md hover:border-blue-500 transition duration-300"
              >
                <div className="flex items-center justify-between mb-2">
                  <div className="text-sm text-gray-600">
                    {data.Snm}
                    <br />
                    <br />
                    {data.CompST}
                  </div>
                  <div className="px-2 py-1 text-white bg-red-500 rounded">
                    {data.Events[0].Epr === 1 ? "LIVE" : "Yet to Start"}
                  </div>
                </div>
                <div className="flex items-center mb-2">
                  <div className="flex items-center">
                    <img src={`https://lsm-static-prod.livescore.com/medium/${data.Events[0].T1[0].Img}`} alt=""  />
                    <span className="text-normal ml-4">{data.Events[0].T1[0].Nm}</span>
                  </div>
                  <div className="ml-4">{data.Events[0].Tr1}</div>
                </div>
                <div className="flex items-center">
                  <div className="flex items-center">
                  <img src={`https://lsm-static-prod.livescore.com/medium/${data.Events[0].T2[0].Img}`} alt=""  />
                    <span className="text-normal ml-4">{data.Events[0].T2[0].Nm}</span>
                  </div>
                  <div className="ml-4">{data.Events[0].Tr2}</div>
                </div>
                <div className="text-xs text-red-600">{data.liveText}</div>
                <br />
                <div className="text-xs text-red-600">{data.textComplete}</div>
              </a>
            </section>
          );
        })}
      </div>
    );
  }else{
    return <div className="h-screen bg-white w-full text-center p-10">
    <Box>
      <CircularProgress />
    </Box>
  </div>
  }
};

export default FootballCard;



// if (matchInfo.length !== 0) {
//   return (
//     <div className="flex flex-wrap items-center justify-between">
//       {matchInfo.map((data) => {
//         return (
//           <section className="lg:w-1/3" key={data.matchId}>
//             <a
//               title=""
//               href="https://cricbuzz.com/live-cricket-scores/"
//               target="blank"
//               className="block mb-4 p-4 border border-white rounded-md hover:border-blue-500 transition duration-300"
//             >
//               <div className="flex items-center justify-between mb-2">
//                 <div className="text-sm text-gray-600">
//                   {data.matchNumberVenue}
//                   <br />
//                   <br />
//                   {data.teamHeading}
//                 </div>
//                 <div className="px-2 py-1 text-white bg-red-500 rounded">
//                   {data.status}
//                 </div>
//               </div>
//               <div className="flex items-center mb-2">
//                 <div className="flex items-center">
//                   <span className="text-normal">{data.battingTeam}</span>
//                 </div>
//                 <div className="ml-4">{data.battingTeamScore}</div>
//               </div>
//               <div className="flex items-center">
//                 <div className="flex items-center">
//                   <span className="text-normal">{data.bowlTeam}</span>
//                 </div>
//                 <div className="ml-4">{data.bowlTeamScore}</div>
//               </div>
//               <div className="text-xs text-red-600">{data.liveText}</div>
//               <br />
//               <div className="text-xs text-red-600">{data.textComplete}</div>
//             </a>
//           </section>
//         );
//       })}
//     </div>
//   );
// }else{
//   return <div className="h-screen bg-white w-full text-center p-10">
//   <Box>
//     <CircularProgress />
//   </Box>
// </div>
// }