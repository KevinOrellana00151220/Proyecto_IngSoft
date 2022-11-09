const express = require("express");
const mongoose  = require("mongoose");
require("dotenv").config();
const authRoute = require("./routers/auth");
const userRoute = require("./routers/user");
const jobRoute = require("./routers/job");
const departmentRoute = require("./routers/department");
const worktypeRoute = require("./routers/worktype");
const inscriptionRoute = require("./routers/inscription");
const curriculumRoute = require("./routers/curriculum");
const verifytoken = require("./token/verify_token");

// settings
const app = express();
const port = process.env.PORT || 9000;

// middlewares
app.use(express.json());
app.use(authRoute);
app.use(departmentRoute);
app.use(userRoute);
app.use(jobRoute);
app.use(curriculumRoute);
app.use(worktypeRoute);
app.use(inscriptionRoute);


// routes
app.get("/", (req, res) => {
  res.send("Welcome to my API");
});

//Connect to MongoDB
mongoose
  .connect('mongodb+srv://00151220:5D9C4AE8@guanacocluster.c0cog.mongodb.net/?retryWrites=true&w=majority')
  .then(() => console.log("Connected to MongoDB Atlas"))
  .catch((error) => console.error(error));

// server listening
app.listen(port, () => console.log("Server listening to", port));
