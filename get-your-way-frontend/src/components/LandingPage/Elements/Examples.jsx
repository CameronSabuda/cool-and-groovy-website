import React from "react";
import { Container, Row, Col, Image } from "react-bootstrap";

const Examples = () => {
	return (
		<div className='bg-light py-5'>
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
								Lorem ipsum dolor sit amet consectetur adipisicing
								elit. Non facere consequatur quo nulla quidem, culpa
								laudantium omnis quos doloribus ut, ducimus quod!
								Animi ex soluta sit fuga. Dignissimos, nam eligendi!
								Impedit porro error debitis, itaque mollitia ut
								veniam provident aspernatur temporibus, minus, iusto
								laborum cumque sunt natus qui.
							</p>
						</Row>
					</Col>
				</Row>
				<Row className='d-flex justify-content-center py-4 px-4'>
					<Col>
						<h2>Show Events</h2>
						<p>
							Lorem ipsum dolor sit, amet consectetur adipisicing
							elit. Ad nesciunt at assumenda, ab laboriosam
							debitis. Iusto rem cumque voluptate adipisci, a,
							explicabo laborum necessitatibus quas repellat
							voluptas placeat cupiditate at.
						</p>
					</Col>
					<Col>
						<Image
							src='https://picsum.photos/600/800'
							rounded
							fluid
						/>
					</Col>
				</Row>
			</Container>
		</div>
	);
};

export default Examples;
