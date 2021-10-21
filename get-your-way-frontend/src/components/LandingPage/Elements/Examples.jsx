import React from "react";
import { Container, Row, Col, Image } from "react-bootstrap";

const Examples = () => {
	return (
		<div id="about-us" className='bg-light py-5'>
			<Container>
				<Row className='d-flex justify-content-center py-4 px-4'>
					<Col className="d-flex align-items-center">
						<Image
							src='https://picsum.photos/800/1200'
							rounded
							fluid
						/>

					</Col>
					<Col className="d-flex flex-column align-items-center justify-content-center">
						<Row>
							<h2>What we do</h2>
						</Row>
						<Row className="">
							<p>
								Using GetYourWay you can get real, live info on the locations that 
								your favourite films have been shot in.
							</p>
							<p>By selecting any of the movies listed 
								on the Movies page, you can see a map of some of the main locations that have
								been used to shoot the chosen movie.
							</p>
							<p>Clicking on any of these locations will 
								update the widgets to the right of the map with all the info to help you decide
								on whether this place is the location for your next holiday!</p>
							
						</Row>
					</Col>
				</Row>
			</Container>
		</div>
	);
};

export default Examples;
