package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class EmailMessage(emailThreadIDField:EmailThreadIDField,
                        emailTypeField:EmailTypeField,
                        origTimeField:Option[OrigTimeField]=None,
                        subjectField:SubjectField,
                        encodedSubjectLenField:Option[EncodedSubjectLenField]=None,
                        encodedSubjectField:Option[EncodedSubjectField]=None,
                        routingGrpComponent:Option[RoutingGrpComponent]=None,
                        instrmtGrpComponent:Option[InstrmtGrpComponent]=None,
                        undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                        instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                        orderIDField:Option[OrderIDField]=None,
                        clOrdIDField:Option[ClOrdIDField]=None,
                        linesOfTextGrpComponent:LinesOfTextGrpComponent,
                        rawDataLengthField:Option[RawDataLengthField]=None,
                        rawDataField:Option[RawDataField]=None) extends SfFixMessageBody("C")  with SfFixRenderable with SfFixFieldsToAscii {

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
    routingGrpComponent.foreach(fmt(b,_))
    instrmtGrpComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    orderIDField.foreach(fmt(b,_))
    clOrdIDField.foreach(fmt(b,_))
    fmt(b,linesOfTextGrpComponent)
    rawDataLengthField.foreach(fmt(b,_))
    rawDataField.foreach(fmt(b,_))
    b
  }

}
     
object EmailMessage extends SfFixMessageDecoder {
  val MsgType="C"
  val MsgName="Email"
             
  override val MandatoryFields = HashSet[Int](
    EmailThreadIDField.TagId, EmailTypeField.TagId, SubjectField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    RoutingGrpComponent.isMandatoryField(tagId) || InstrmtGrpComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || 
    LinesOfTextGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    OrigTimeField.TagId, EncodedSubjectLenField.TagId, EncodedSubjectField.TagId, OrderIDField.TagId, ClOrdIDField.TagId, 
    RawDataLengthField.TagId, RawDataField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    RoutingGrpComponent.isOptionalField(tagId) || InstrmtGrpComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId) || 
    LinesOfTextGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    RoutingGrpComponent.isFieldOf(tagId) || InstrmtGrpComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId) || 
    InstrmtLegGrpComponent.isFieldOf(tagId) || LinesOfTextGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
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
        RoutingGrpComponent.decode(flds, startPos),
        InstrmtGrpComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        InstrmtLegGrpComponent.decode(flds, startPos),
        myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        LinesOfTextGrpComponent.decode(flds, startPos).get,
        myFields.get(RawDataLengthField.TagId).flatMap(f=>RawDataLengthField.decode(f)),
        myFields.get(RawDataField.TagId).flatMap(f=>RawDataField.decode(f))))
    } else None
  }

    
}
     