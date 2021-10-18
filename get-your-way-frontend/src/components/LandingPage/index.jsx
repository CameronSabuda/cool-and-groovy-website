import React from "react";
import Hero from "./Elements/Hero.jsx";
import Example from "./Elements/Examples.jsx";
import Test from "./Elements/Test"
import NavigationBar from "../NavigationBar/NavigationBar.jsx";
import Footer from "../Footer/Footer.jsx";

const index = () => {
	return (
		<div>
			<NavigationBar />
			<Hero />
			<Example />
			<Test />
			<Footer />
		</div>
	);
};

export default index;
