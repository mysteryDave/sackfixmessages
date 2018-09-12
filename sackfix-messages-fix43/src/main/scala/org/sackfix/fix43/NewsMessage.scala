package org.sackfix.fix43

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX43.xml
  */
case class NewsMessage(origTimeField:Option[OrigTimeField]=None,
                       urgencyField:Option[UrgencyField]=None,
                       headlineField:HeadlineField,
                       encodedHeadlineLenField:Option[EncodedHeadlineLenField]=None,
                       encodedHeadlineField:Option[EncodedHeadlineField]=None,
                       noRoutingIDsField:Option[NoRoutingIDsField]=None,
                       routingIDsGroups: Option[List[RoutingIDsGroup]]=None,
                       noRelatedSymField:Option[NoRelatedSymField]=None,
                       relatedSymGroups: Option[List[RelatedSymGroup]]=None,
                       linesOfTextField:LinesOfTextField,
                       linesOfTextGroups: List[LinesOfTextGroup],
                       uRLLinkField:Option[URLLinkField]=None,
                       rawDataLengthField:Option[RawDataLengthField]=None,
                       rawDataField:Option[RawDataField]=None) extends SfFixMessageBody("B")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noRoutingIDsField.map(_.value).getOrElse(0) != routingIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoRoutingIDsField.TagId,noRoutingIDsField.map(_.value).getOrElse(0), routingIDsGroups.map(_.size).getOrElse(0))
  if (noRelatedSymField.map(_.value).getOrElse(0) != relatedSymGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoRelatedSymField.TagId,noRelatedSymField.map(_.value).getOrElse(0), relatedSymGroups.map(_.size).getOrElse(0))
  if (linesOfTextField.value != linesOfTextGroups.size)
    throw SfRepeatingGroupCountException(LinesOfTextField.TagId,linesOfTextField.value, linesOfTextGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    origTimeField.foreach(fmt(b,_))
    urgencyField.foreach(fmt(b,_))
    fmt(b,headlineField)
    encodedHeadlineLenField.foreach(fmt(b,_))
    encodedHeadlineField.foreach(fmt(b,_))
    noRoutingIDsField.foreach(fmt(b,_))
    routingIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    noRelatedSymField.foreach(fmt(b,_))
    relatedSymGroups.getOrElse(List.empty).foreach(fmt(b,_))
    fmt(b,linesOfTextField)
    uRLLinkField.foreach(fmt(b,_))
    rawDataLengthField.foreach(fmt(b,_))
    rawDataField.foreach(fmt(b,_))
    b
  }

}
     
object NewsMessage extends SfFixMessageDecoder {
  val MsgType="B"
  val MsgName="News"
             
  override val MandatoryFields = HashSet[Int](
    HeadlineField.TagId, LinesOfTextField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    RoutingIDsGroup.isMandatoryField(tagId) || RelatedSymGroup.isMandatoryField(tagId) || LinesOfTextGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    OrigTimeField.TagId, UrgencyField.TagId, EncodedHeadlineLenField.TagId, EncodedHeadlineField.TagId, NoRoutingIDsField.TagId, 
    NoRelatedSymField.TagId, URLLinkField.TagId, RawDataLengthField.TagId, RawDataField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    RoutingIDsGroup.isOptionalField(tagId) || RelatedSymGroup.isOptionalField(tagId) || LinesOfTextGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    RoutingIDsGroup.isFieldOf(tagId) || RelatedSymGroup.isFieldOf(tagId) || LinesOfTextGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoRoutingIDsField.TagId, NoRelatedSymField.TagId, LinesOfTextField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==OrigTimeField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(NewsMessage(myFields.get(OrigTimeField.TagId).flatMap(f=>OrigTimeField.decode(f)),
        myFields.get(UrgencyField.TagId).flatMap(f=>UrgencyField.decode(f)),
        HeadlineField.decode(myFields.get(HeadlineField.TagId)).get,
        myFields.get(EncodedHeadlineLenField.TagId).flatMap(f=>EncodedHeadlineLenField.decode(f)),
        myFields.get(EncodedHeadlineField.TagId).flatMap(f=>EncodedHeadlineField.decode(f)),
        myFields.get(NoRoutingIDsField.TagId).flatMap(f=>NoRoutingIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoRoutingIDsField.TagId)) RoutingIDsGroup.decode(flds, nextTagPosLookup(NoRoutingIDsField.TagId)) else None,
        myFields.get(NoRelatedSymField.TagId).flatMap(f=>NoRelatedSymField.decode(f)),
        if (nextTagPosLookup.contains(NoRelatedSymField.TagId)) RelatedSymGroup.decode(flds, nextTagPosLookup(NoRelatedSymField.TagId)) else None,
        LinesOfTextField.decode(myFields.get(LinesOfTextField.TagId)).get,
        if (nextTagPosLookup.contains(LinesOfTextField.TagId)) LinesOfTextGroup.decode(flds, nextTagPosLookup(LinesOfTextField.TagId)).get else List.empty,
        myFields.get(URLLinkField.TagId).flatMap(f=>URLLinkField.decode(f)),
        myFields.get(RawDataLengthField.TagId).flatMap(f=>RawDataLengthField.decode(f)),
        myFields.get(RawDataField.TagId).flatMap(f=>RawDataField.decode(f))))
    } else None
  }

    
}
     