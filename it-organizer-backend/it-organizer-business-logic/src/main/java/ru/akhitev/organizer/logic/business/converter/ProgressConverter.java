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

import org.springframework.stereotype.Component;
import ru.akhitev.organizer.db.entity.Progress;
import ru.akhitev.organizer.logic.business.dto.ticket.progress.ProgressForEdit;
import ru.akhitev.organizer.logic.business.vo.ticket.progress.ProgressForShow;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

/** {@inheritDoc} */
@Component
public class ProgressConverter implements Converter<Progress, ProgressForShow, ProgressForEdit> {

    /** {@inheritDoc} */
    public Set<ProgressForShow> prepareForShow(Collection<Progress> progresses) {
        if (progresses == null) {
            return Collections.emptySet();
        }
        return progresses.stream()
                .map( progress ->
                        new ProgressForShow(progress.getId(), progress.getDate(),
                                progress.getStatus()))
                .collect(Collectors.toSet());
    }

    /** {@inheritDoc} */
    public ProgressForEdit prepareForEdit(Progress progress) {
        return new ProgressForEdit(progress.getId(), progress.getStatus());
    }

    //TODO
    /** {@inheritDoc} */
    @Override
    public Progress merge(Progress entity, ProgressForEdit dataTransferObject) {
        if (entity == null) {
            entity = new Progress();
        }
        entity.setStatus(dataTransferObject.getProgress());
        entity.setDate(new Date());
        return entity;
    }
}
