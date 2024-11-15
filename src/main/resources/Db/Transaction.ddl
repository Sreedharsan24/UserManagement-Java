CREATE TABLE IF NOT EXISTS public.transaction
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    created_at timestamp(6) without time zone NOT NULL,
    status character varying(20) COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp(6) without time zone NOT NULL,
    ticket_id bigint NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT transaction_pkey PRIMARY KEY (id),
    CONSTRAINT fkanjpo5tiapru7an6cw4cu37y4 FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkaowu76tt2grelstxnb2dr0rtd FOREIGN KEY (ticket_id)
        REFERENCES public.tickets (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT transaction_status_check CHECK (status::text = ANY (ARRAY['Active'::character varying, 'Inactive'::character varying]::text[]))
)

TABLESPACE pg_default;