import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { CrudOperations } from './interface/crud-operations';
import { HttpResp, ObsResp } from './interface/response.utils';

import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CrudService<E, Dto> implements CrudOperations<E, Dto> {

    private readonly host = environment.URL_API;
    private readonly endPoint;

    entities: E[] = [];

    constructor(
      protected http: HttpClient,
      protected endpoint: string
    ) {
      this.endPoint = `${this.host}/${this.endpoint}`;
    }

    create(createDto: Dto): ObsResp<E> {
      return this.http.post<HttpResp<E>>(this.endPoint, createDto);
    }

    findAll(): ObsResp<E[]> {
      return this.http.get<HttpResp<E[]>>(this.endPoint);
    }

    findAllPageable(page: number, size: number): ObsResp<any> {
      return this.http.get<HttpResp<any>>(`${this.endPoint}?page=${page}&size=${size}`);
    }

    findAllPageableWithFilter(filter: string, page: number, size: number): ObsResp<any> {
      return this.http.get<HttpResp<any>>(`${this.endPoint}?filter=${filter}&page=${page}&size=${size}`);
    }

    findById(id: number | string): ObsResp<E> {
      return this.http.get<HttpResp<E>>(`${this.endPoint}/${id}`);
    }

    updateById(id: number | string, updateDto: Dto): ObsResp<E> {
      return this.http.patch<HttpResp<E>>(`${this.endPoint}/${id}`, updateDto);
    }

    deleteById(id: number | string): ObsResp<string> {
      return this.http.delete<HttpResp<string>>(`${this.endPoint}/${id}`);
    }
  }
