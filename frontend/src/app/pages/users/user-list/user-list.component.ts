import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/service/user.service';
import { SubSink } from 'subsink';

@Component({
    selector: 'app-user-list',
    templateUrl: './user-list.component.html',
    styleUrls: ['./user-list.component.scss'],
    providers: [MessageService]
})
export class UserListComponent implements OnInit, OnDestroy {
    private readonly subs = new SubSink();

    currentPage = 0;
    pageSize = 25;
    nroTotalRecords = 0;
    nroTotalPages = 0;
    recordSort = 'firstName';

    users: User[];
    user: User;
    selectedUsers: User[];

    cols: any[];
    genders: any[];
    rowsPerPageOptions = [5, 10, 20];

    constructor(
        private readonly messageService: MessageService,
        private readonly userService: UserService
    ) {}

    ngOnInit(): void {
        this.loadUsers();

        this.cols = [
            { field: 'firstName', header: 'First name' },
            { field: 'lastName', header: 'Last name' },
            { field: 'email', header: 'Email' },
            { field: 'gender', header: 'Gender' },
            { field: 'ipAddress', header: 'IP Address' },
        ];

        this.genders = [
            { label: 'Male', value: 'Male' },
            { label: 'Female', value: 'Female' },
        ];
    }

    ngOnDestroy(): void {
        this.subs.unsubscribe();
    }

    loadUsers() {
        this.subs.sink = this.userService
            .readAll(this.currentPage, this.pageSize, this.recordSort)
            .subscribe({
                next: (res) => {
                    debugger;
                    this.users = res.content || [];
                    this.currentPage = res.number;
                    this.pageSize = res.size;
                    this.nroTotalRecords = res.totalElements;
                    this.nroTotalPages = res.totalPages;
                },
                error: (httpError: HttpErrorResponse) => {
                    this.messageService.add({
                        key: 'toast',
                        severity: 'error',
                        summary: 'Error',
                        detail: `${httpError.error.data}`,
                    });
                },
            });
    }

    onPage($event) {
        debugger;
        this.currentPage = $event.page;
        this.pageSize = $event.rows;
        this.loadUsers();
    }

    add() {}

    deletes() {}

    edit(product: User) {}

    delete(product: User) {}
}
