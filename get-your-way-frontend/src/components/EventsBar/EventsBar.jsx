import React, { useEffect, useState } from 'react'
import EventsTile from './EventsTile/EventsTile'
import axios from 'axios'
import { Container,  CardGroup } from 'react-bootstrap'
import Loader from '../Loader/Loader'
import './EventsBar.css'


const EventsBar = ({lat, lng}) => {
	const [eventsData, setEventsData] = useState()
	const [isLoading, setLoading] = useState(true)

	const client = axios.create({
		baseURL: `http://99.81.186.138:9090/events?latitude=${lat}&longitude=${lng}`,
	})

	useEffect(() => {
		const getEvents = async () => {
			let response = await client.get()
			let { events } = response.data

			setEventsData(events)
			setLoading(false)
		}
		getEvents()
	}, [lat, lng, client])

	return (
		<div className='EventsBar bg-secondary px-2 py-3'>
			<Container>
				<CardGroup className='d-flex flex-row flex-nowrap scrolling'>
					{isLoading && <Loader />}
					{!isLoading &&
						eventsData.map((event, i) => {
							return <EventsTile data={event} key={i} />
						})}
				</CardGroup>
			</Container>
		</div>
	)
}

export default EventsBar
