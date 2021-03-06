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
package ru.akhitev.organizer.logic.business.converter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.akhitev.organizer.db.entity.Ticket;
import ru.akhitev.organizer.db.entity.TicketLink;
import ru.akhitev.organizer.logic.business.dto.ticket.link.TicketLinkForEdit;
import ru.akhitev.organizer.logic.business.vo.ticket.link.TicketLinkForShow;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/** {@inheritDoc} */
@Component
public class TicketLinkConverter implements Converter<TicketLink, TicketLinkForShow, TicketLinkForEdit> {

    /** size for adjustment too long names */
    @Value("${name.size}")
    private Integer nameSize;

    /** {@inheritDoc} */
    @Override
    public Set<TicketLinkForShow> prepareForShow(Collection<TicketLink> links) {
        if (links == null) {
            return Collections.emptySet();
        }
        return links.stream()
                .map( link ->
                        new TicketLinkForShow(link.getId(),
                                link.getType(),
                                link.getName(),
                                link.getLink()))
                .collect(Collectors.toSet());
    }

    // TODO
    /** {@inheritDoc} */
    @Override
    public TicketLinkForEdit prepareForEdit(TicketLink entity) {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public TicketLink merge(TicketLink link, TicketLinkForEdit linkForEditor) {
        if (link == null) {
            link = new TicketLink();
        }
        link.setName(linkForEditor.getName());
        link.setType(linkForEditor.getType());
        link.setLink(linkForEditor.getLink());
        return link;
    }
}
