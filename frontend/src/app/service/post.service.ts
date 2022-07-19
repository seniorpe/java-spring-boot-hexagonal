import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Post } from '../model/post';
import { CrudService } from './crud.service';

import { environment } from 'src/environments/environment';
import { ObsResp, HttpResp } from './interface/response.utils';

@Injectable({
    providedIn: 'root',
})
export class PostService extends CrudService<Post, null> {
    private readonly _host = environment.URL_API;
    private readonly _endPoint;

    constructor(protected readonly http: HttpClient) {
        super(http, 'posts');
        this._endPoint = `${this._host}/${this.endpoint}`;
    }

    findAllFilter(page: number, size: number): ObsResp<any> {
        return this.http.get<HttpResp<any>>(
            `${this._endPoint}?page=${page}&size=${size}`
        );
    }
}
