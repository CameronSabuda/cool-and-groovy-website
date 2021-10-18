import React from "react";
import Hero from "./Elements/Hero.jsx";
import Example from "./Elements/Examples.jsx";
import Test from "./Elements/Test";
import NavigationBar from "../NavigationBar/NavigationBar.jsx";
import Footer from "../Footer/Footer.jsx";
import TryItOut from "./Elements/TryItOut.jsx";

const index = () => {
	return (
		<div>
			<NavigationBar />
			<Hero />
			<Example />
			<Test />
			<TryItOut />
			<Footer />
		</div>
	);
};

export default index;
