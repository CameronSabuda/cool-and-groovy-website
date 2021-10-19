import React from "react";
import NavigationBar from "../NavigationBar/NavigationBar.jsx";
import Footer from "../Footer/Footer.jsx";
import MovieList from "./Elements/MovieList.jsx";

const index = () => {
	return (
		<div>
			<NavigationBar />
			<MovieList />
			<Footer />
		</div>
	);
};

export default index;
