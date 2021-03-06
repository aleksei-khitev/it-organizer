/*
 * IT-Organizer is an organizer for a developer and other IT-specialists.
 * Copyright (c) 2017 Aleksei Khitev (Хитёв Алексей Юрьевич).
 *
 * This file is part of IT-Organizer
 *
 * IT-Organizer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * IT-Organizer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */
package ru.akhitev.organizer.logic.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.akhitev.organizer.db.entity.Ticket;
import ru.akhitev.organizer.db.entity.TicketLink;
import ru.akhitev.organizer.logic.business.converter.TicketLinkConverter;
import ru.akhitev.organizer.logic.business.dto.ticket.link.TicketLinkForEdit;
import ru.akhitev.organizer.db.repository.TicketLinkRepository;
import ru.akhitev.organizer.logic.business.vo.ticket.link.TicketLinkForShow;

import java.util.Set;

/** {@inheritDoc} */
@Service
public class TicketLinkService extends AbstractNodeService<Ticket, TicketLinkConverter, TicketLinkRepository, TicketLink, TicketLinkForShow, TicketLinkForEdit> {

    /** Uses for getting {@link TicketService#activeTicket}. */
    private final TicketService ticketService;

    @Autowired
    public TicketLinkService(TicketLinkRepository repository, TicketLinkConverter converter, TicketService ticketService) {
        super(converter, repository);
        this.ticketService = ticketService;
    }

    /** {@inheritDoc} */
    @Override
    Set<TicketLink> queryEntitiesForActiveRoot() {
        return repository.findByTicket(ticketService.getActiveTicket());
    }

    /** {@inheritDoc} */
    @Override
    Ticket activeRoot() {
        return ticketService.getActiveTicket();
    }
}
