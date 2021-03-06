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
package ru.akhitev.organizer.logic.business.dto.ticket;

import ru.akhitev.organizer.db.enums.Status;
import ru.akhitev.organizer.logic.business.dto.DataTransferObject;
import ru.akhitev.organizer.logic.business.vo.ticket.link.TicketLinkForShow;

import java.util.Set;

public class TicketForEdit implements TemplatedDisplayName, DataTransferObject {
    private Integer id;
    private Integer projectId;
    private String key;
    private String priority;
    private String name;
    private String workspace;
    private String displayedName;
    private Status status;
    private String stepsToReproduce;
    private Set<TicketLinkForShow> links;

    public TicketForEdit() {}

    public TicketForEdit(Integer id, Integer projectId, String key, String priority, String name, String workspace,
                         Status status, String stepsToReproduce, Set<TicketLinkForShow> links) {
        this.id = id;
        this.projectId = projectId;
        this.key = key;
        this.priority = priority;
        this.name = name;
        this.workspace = workspace;
        this.status = status;
        this.stepsToReproduce = stepsToReproduce;
        this.links = links;
        this.displayedName = String.format(DISPLAYED_NAME_TEMPLATE, key, priority, name);
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisplayedName() {return displayedName;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getStepsToReproduce() {
        return stepsToReproduce;
    }

    public void setStepsToReproduce(String stepsToReproduce) {
        this.stepsToReproduce = stepsToReproduce;
    }

    public Set<TicketLinkForShow> getLinks() {
        return links;
    }

    public void setLinks(Set<TicketLinkForShow> links) {
        this.links = links;
    }
}
