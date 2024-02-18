const options = {
  method: "GET",
  url: "https://livescore6.p.rapidapi.com/matches/v2/list-live",
  params: {
    Category: "soccer",
    Timezone: "-7",
  },
  headers: {
    "X-RapidAPI-Key": "17a449dbb8msh0ddd34241c5b186p1fca90jsnb7547bc483bd",
    "X-RapidAPI-Host": "livescore6.p.rapidapi.com",
  },
};

export default options;