import { Component, OnDestroy, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { PostService } from 'src/app/service/post.service';
import { SubSink } from 'subsink';

@Component({
    selector: 'app-post-list',
    templateUrl: './post-list.component.html',
    styleUrls: ['./post-list.component.scss'],
    providers: [MessageService]
})
export class PostListComponent implements OnInit, OnDestroy {
    private readonly subs = new SubSink();

    currentPage = 0;
    pageSize = 25;
    nroTotalRecords = 0;
    nroTotalPages = 0;

    constructor(
        private readonly messageService: MessageService,
        private readonly postService: PostService
    ) {}

    ngOnInit(): void {}

    ngOnDestroy(): void {
        this.subs.unsubscribe();
    }
}
