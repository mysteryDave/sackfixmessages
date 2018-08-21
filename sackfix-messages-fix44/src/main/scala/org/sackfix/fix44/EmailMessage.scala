package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class EmailMessage(emailThreadIDField:EmailThreadIDField,
                        emailTypeField:EmailTypeField,
                        origTimeField:Option[OrigTimeField]=None,
                        subjectField:SubjectField,
                        encodedSubjectLenField:Option[EncodedSubjectLenField]=None,
                        encodedSubjectField:Option[EncodedSubjectField]=None,
                        noRoutingIDsField:Option[NoRoutingIDsField]=None,
                        routingIDsGroups: Option[List[RoutingIDsGroup]]=None,
                        noRelatedSymField:Option[NoRelatedSymField]=None,
                        relatedSymGroups: Option[List[RelatedSymGroup]]=None,
                        noUnderlyingsField:Option[NoUnderlyingsField]=None,
                        underlyingsGroups: Option[List[UnderlyingsGroup]]=None,
                        noLegsField:Option[NoLegsField]=None,
                        legsGroups: Option[List[LegsGroup]]=None,
                        orderIDField:Option[OrderIDField]=None,
                        clOrdIDField:Option[ClOrdIDField]=None,
                        linesOfTextField:LinesOfTextField,
                        linesOfTextGroups: List[LinesOfTextGroup],
                        rawDataLengthField:Option[RawDataLengthField]=None,
                        rawDataField:Option[RawDataField]=None) extends SfFixMessageBody("C")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noRoutingIDsField.map(_.value).getOrElse(0) != routingIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoRoutingIDsField.TagId,noRoutingIDsField.map(_.value).getOrElse(0), routingIDsGroups.map(_.size).getOrElse(0))
  if (noRelatedSymField.map(_.value).getOrElse(0) != relatedSymGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoRelatedSymField.TagId,noRelatedSymField.map(_.value).getOrElse(0), relatedSymGroups.map(_.size).getOrElse(0))
  if (noUnderlyingsField.map(_.value).getOrElse(0) != underlyingsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUnderlyingsField.TagId,noUnderlyingsField.map(_.value).getOrElse(0), underlyingsGroups.map(_.size).getOrElse(0))
  if (noLegsField.map(_.value).getOrElse(0) != legsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoLegsField.TagId,noLegsField.map(_.value).getOrElse(0), legsGroups.map(_.size).getOrElse(0))
  if (linesOfTextField.value != linesOfTextGroups.size)
    throw SfRepeatingGroupCountException(LinesOfTextField.TagId,linesOfTextField.value, linesOfTextGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,emailThreadIDField)
    fmt(b,emailTypeField)
    origTimeField.foreach(fmt(b,_))
    fmt(b,subjectField)
    encodedSubjectLenField.foreach(fmt(b,_))
    encodedSubjectField.foreach(fmt(b,_))
    noRoutingIDsField.foreach(fmt(b,_))
    routingIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    noRelatedSymField.foreach(fmt(b,_))
    relatedSymGroups.getOrElse(List.empty).foreach(fmt(b,_))
    noUnderlyingsField.foreach(fmt(b,_))
    underlyingsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    noLegsField.foreach(fmt(b,_))
    legsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    orderIDField.foreach(fmt(b,_))
    clOrdIDField.foreach(fmt(b,_))
    fmt(b,linesOfTextField)
    rawDataLengthField.foreach(fmt(b,_))
    rawDataField.foreach(fmt(b,_))
    b
  }

}
     
object EmailMessage extends SfFixMessageDecoder {
  val MsgType="C"
  val MsgName="Email"
             
  override val MandatoryFields = HashSet[Int](
    EmailThreadIDField.TagId, EmailTypeField.TagId, SubjectField.TagId, LinesOfTextField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    RoutingIDsGroup.isMandatoryField(tagId) || RelatedSymGroup.isMandatoryField(tagId) || UnderlyingsGroup.isMandatoryField(tagId) || LegsGroup.isMandatoryField(tagId) || 
    LinesOfTextGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    OrigTimeField.TagId, EncodedSubjectLenField.TagId, EncodedSubjectField.TagId, NoRoutingIDsField.TagId, NoRelatedSymField.TagId, 
    NoUnderlyingsField.TagId, NoLegsField.TagId, OrderIDField.TagId, ClOrdIDField.TagId, RawDataLengthField.TagId, 
    RawDataField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    RoutingIDsGroup.isOptionalField(tagId) || RelatedSymGroup.isOptionalField(tagId) || UnderlyingsGroup.isOptionalField(tagId) || LegsGroup.isOptionalField(tagId) || 
    LinesOfTextGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    RoutingIDsGroup.isFieldOf(tagId) || RelatedSymGroup.isFieldOf(tagId) || UnderlyingsGroup.isFieldOf(tagId) || 
    LegsGroup.isFieldOf(tagId) || LinesOfTextGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoRoutingIDsField.TagId, NoRelatedSymField.TagId, NoUnderlyingsField.TagId, NoLegsField.TagId, LinesOfTextField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==EmailThreadIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(EmailMessage(EmailThreadIDField.decode(myFields.get(EmailThreadIDField.TagId)).get,
        EmailTypeField.decode(myFields.get(EmailTypeField.TagId)).get,
        myFields.get(OrigTimeField.TagId).flatMap(f=>OrigTimeField.decode(f)),
        SubjectField.decode(myFields.get(SubjectField.TagId)).get,
        myFields.get(EncodedSubjectLenField.TagId).flatMap(f=>EncodedSubjectLenField.decode(f)),
        myFields.get(EncodedSubjectField.TagId).flatMap(f=>EncodedSubjectField.decode(f)),
        myFields.get(NoRoutingIDsField.TagId).flatMap(f=>NoRoutingIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoRoutingIDsField.TagId)) RoutingIDsGroup.decode(flds, nextTagPosLookup(NoRoutingIDsField.TagId)) else None,
        myFields.get(NoRelatedSymField.TagId).flatMap(f=>NoRelatedSymField.decode(f)),
        if (nextTagPosLookup.contains(NoRelatedSymField.TagId)) RelatedSymGroup.decode(flds, nextTagPosLookup(NoRelatedSymField.TagId)) else None,
        myFields.get(NoUnderlyingsField.TagId).flatMap(f=>NoUnderlyingsField.decode(f)),
        if (nextTagPosLookup.contains(NoUnderlyingsField.TagId)) UnderlyingsGroup.decode(flds, nextTagPosLookup(NoUnderlyingsField.TagId)) else None,
        myFields.get(NoLegsField.TagId).flatMap(f=>NoLegsField.decode(f)),
        if (nextTagPosLookup.contains(NoLegsField.TagId)) LegsGroup.decode(flds, nextTagPosLookup(NoLegsField.TagId)) else None,
        myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        LinesOfTextField.decode(myFields.get(LinesOfTextField.TagId)).get,
        if (nextTagPosLookup.contains(LinesOfTextField.TagId)) LinesOfTextGroup.decode(flds, nextTagPosLookup(LinesOfTextField.TagId)).get else List.empty,
        myFields.get(RawDataLengthField.TagId).flatMap(f=>RawDataLengthField.decode(f)),
        myFields.get(RawDataField.TagId).flatMap(f=>RawDataField.decode(f))))
    } else None
  }

    
}
     