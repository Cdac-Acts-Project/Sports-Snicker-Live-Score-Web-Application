import React from "react";
import axios from "axios";
import { useState,useEffect } from "react";
import { CircularProgress } from '@mui/material';
import Box from "@mui/material/Box";


const CricketMatchCard = () => {
  let jwtToken = localStorage.getItem("jwtToken");

  const [matchInfo, setmatchInfo] = useState([]);

  const handleApi = async () => {
    await axios
      .get("http://localhost:8081/cricket/live", {
        headers: { Authorization: `Bearer ${jwtToken}` },
      })
      .then((response) => {
        setmatchInfo(response.data);
      })
      .catch((e) => {
        console.log(e);
      });
  };

  useEffect(() => {
    handleApi();
  })

  if (matchInfo.length !== 0) {
    return (
      <div className="flex flex-wrap items-center justify-between">
        {matchInfo.map((data) => {
          return (
            <section className="lg:w-1/3" key={data.matchId}>
              <a
                title=""
                href="https://cricbuzz.com/live-cricket-scores/"
                target="blank"
                className="block mb-4 p-4 border border-white rounded-md hover:border-blue-500 transition duration-300"
              >
                <div className="flex items-center justify-between mb-2">
                  <div className="text-sm text-gray-600">
                    {data.matchNumberVenue}
                    <br />
                    <br />
                    {data.teamHeading}
                  </div>
                  <div className="px-2 py-1 text-white bg-red-500 rounded">
                    {data.status}
                  </div>
                </div>
                <div className="flex items-center mb-2">
                  <div className="flex items-center">
                    <span className="text-normal">{data.battingTeam}</span>
                  </div>
                  <div className="ml-4">{data.battingTeamScore}</div>
                </div>
                <div className="flex items-center">
                  <div className="flex items-center">
                    <span className="text-normal">{data.bowlTeam}</span>
                  </div>
                  <div className="ml-4">{data.bowlTeamScore}</div>
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

export default CricketMatchCard;
