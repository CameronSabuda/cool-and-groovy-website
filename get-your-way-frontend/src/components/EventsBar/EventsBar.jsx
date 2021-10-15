import React, { useEffect, useState } from 'react'
import EventsTile from './EventsTile/EventsTile'
import axios from 'axios'
import { CardGroup } from 'react-bootstrap'

const client = axios.create({
	baseURL: 'http://99.81.186.138:9090/events?latitude=51.5074&longitude=-0.1278',
})

const EventsBar = () => {
	const [eventsData, setEventsData] = useState()

	useEffect(() => {
		const getEvents = async () => {
			let response = await client.get()
			let { events } = response.data
			setEventsData(events)
		}
		getEvents()
	}, [])

	return (
		<div className='EventsBar bg-secondary'>
			<CardGroup className='d-flex flex-row'>
				{eventsData &&
					eventsData.map((event, i) => {
						return <EventsTile data={event} key={i} />
					})}
			</CardGroup>
		</div>
	)
}

export default EventsBar
