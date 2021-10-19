import React from "react";
import { Container, Row, Col, Card } from "react-bootstrap";
import captainAmerica from "../Assets/captain-america.jpeg";
import harryPotter from "../Assets/harry-potter.jpeg";
import Chernobyl from "../Assets/chernobyl.jpeg";
import missionImpossible from "../Assets/mission-impossible.jpeg";
import "./MovieList.css";

import { Link } from "react-router-dom";

const Styles = {
	maxHeight: "25%",
	maxWidth: "100%"
};



const MovieList = () => {
	return (
		<div className='bg-light py-5 vh-100'>
			<Container>
				<Row className='movies d-flex gy-4'>
					<Col sm={12} md={6} lg={3}>
						<Card as={Link} to={`/map/captainAmerica`} className='shadow-lg text-center border-0'>
							<Card.Img style={Styles} src={captainAmerica} />
							<Card.ImgOverlay className='text-white'>
								<Card.Title>Captain America</Card.Title>
							</Card.ImgOverlay>
						</Card>
					</Col>
					<Col sm={12} md={6} lg={3}>
						<Card as={Link} to={`/map/harryPotter`} lassName='shadow-lg text-center border-0'>
							<Card.Img style={Styles} src={harryPotter} />
							<Card.ImgOverlay className='text-white'>
								<Card.Title>
									Harry Potter and The Deathly Hallows
								</Card.Title>
							</Card.ImgOverlay>
						</Card>
					</Col>
					<Col sm={12} md={6} lg={3}>
						<Card as={Link} to={`/map/chernobyl`} className='shadow-lg text-center border-0'>
							<Card.Img style={Styles} src={Chernobyl} />
							<Card.ImgOverlay className='text-white'>
								<Card.Title>Chernobyl</Card.Title>
							</Card.ImgOverlay>
						</Card>
					</Col>
					<Col sm={12} md={6} lg={3}>
						<Card as={Link} to={`/map/missionImpossible`} className='shadow-lg text-center border-0'>
							<Card.Img style={Styles} src={missionImpossible} />
							<Card.ImgOverlay className='text-white'>
								<Card.Title>
									Mission Impossible: Fallout
								</Card.Title>
							</Card.ImgOverlay>
						</Card>
					</Col>
				</Row>
			</Container>
		</div>
	);
};


export default MovieList;
